package org.epragati.serviecImpl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.epragati.cfstVcr.vo.TaxPaidVCRDetailsVO;
import org.epragati.cfstVcr.vo.VcrBookingData;
import org.epragati.cfstVcr.vo.VcrDataModel;
import org.epragati.cfstVcr.vo.VcrInputVo;
import org.epragati.cfstVcr.vo.VcrOffenseDetails;
import org.epragati.cfstVcr.vo.VcrResponseModel;
import org.epragati.service.CfstVcrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tempuri.LicRegVCRDetails;
import org.tempuri.LicRegVCRDetailsSoap;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
@Service
public class CfstVcrServiceImpl implements CfstVcrService {
	private static final Logger logger = LoggerFactory.getLogger(CfstVcrServiceImpl.class);

	@Override
	public List<VcrBookingData> getVcrDetails(VcrInputVo vcrInputVo) {
		try {

			LicRegVCRDetails licRegVCRDetails = new LicRegVCRDetails();
			LicRegVCRDetailsSoap licRegVCRDetailsSoap = licRegVCRDetails.getLicRegVCRDetailsSoap();
			String result = null;
			result = licRegVCRDetailsSoap.getLicRegVCRDetails(vcrInputVo.getDocumentType(), vcrInputVo.getDlNo(),
					vcrInputVo.getRegNo());
			if (result != null && (result.equalsIgnoreCase("0"))) {
				logger.info("Vcr Details Not found for  DL :" + vcrInputVo.getDlNo() + "/ RC NO :"+vcrInputVo.getRegNo());
				return Collections.emptyList();
			}
			if (result != null) {
				logger.info("Vcr Details found for DL :" + vcrInputVo.getDlNo() +"/ RC NO :"+ vcrInputVo.getRegNo());

				JAXBContext jaxbContext = JAXBContext.newInstance(VcrDataModel.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				StringReader reader = new StringReader(result);
				VcrDataModel vcrDetails = (VcrDataModel) unmarshaller.unmarshal(reader);

				List<VcrBookingData> bookings = new ArrayList<VcrBookingData>();
				for (VcrBookingData booking : vcrDetails.getBookingData()) {
					bookings.add(booking);
					List<VcrOffenseDetails> offenseDetails = new ArrayList<VcrOffenseDetails>();
					for (VcrOffenseDetails offense : vcrDetails.getOffenseDetails()) {
						if (booking.getVcrNum() != null
								&& booking.getVcrNum().equalsIgnoreCase(offense.getVcrNumber())) {
							offenseDetails.add(offense);
						}
					}
					booking.setOffenseDetails(offenseDetails);
				}

				VcrResponseModel vcrResponse = new VcrResponseModel();
				vcrResponse.setBookingData(bookings);
				return bookings;

			}
		} catch (Exception e) {
			logger.info("Exception Raised while getting data from Cfst");

		}
		return Collections.emptyList();
	}

	@Override
	public Optional<TaxPaidVCRDetailsVO> getVCRDetailsTaxPaid(String regnNo) {
		try {

			LicRegVCRDetails licRegVCRDetails = new LicRegVCRDetails();
			LicRegVCRDetailsSoap licRegVCRDetailsSoap = licRegVCRDetails.getLicRegVCRDetailsSoap();
			String result = null;
			result = licRegVCRDetailsSoap.getTaxPaidVCRDetails(regnNo);
			if (result != null) {
				logger.info("Vcr tax paid Details found for :[{}],[{}]" + regnNo);

				JAXBContext jaxbContext = JAXBContext.newInstance(TaxPaidVCRDetailsVO.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				StringReader reader = new StringReader(result);
				TaxPaidVCRDetailsVO taxVcrDetails = (TaxPaidVCRDetailsVO) unmarshaller.unmarshal(reader);
				return Optional.of(taxVcrDetails);
			}
		} catch (Exception e) {
			logger.info("Exception Raised while getting data from Cfst");

		}
		return Optional.empty();
	}

}
