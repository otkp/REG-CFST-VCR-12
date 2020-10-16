package org.epragati.service;

import java.util.List;
import java.util.Optional;

import org.epragati.cfstVcr.vo.TaxPaidVCRDetailsVO;
import org.epragati.cfstVcr.vo.VcrInputVo;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
public interface CfstVcrService {
	
	List<org.epragati.cfstVcr.vo.VcrBookingData> getVcrDetails(VcrInputVo vcrInputVo);

	Optional<TaxPaidVCRDetailsVO> getVCRDetailsTaxPaid(String regnNo);

}
