package org.epragati.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.epragati.cfstVcr.vo.TaxPaidVCRDetailsVO;
import org.epragati.cfstVcr.vo.VcrInputVo;
import org.epragati.constants.MessageKeys;
import org.epragati.service.CfstVcrService;
import org.epragati.util.AppMessages;
import org.epragati.util.GateWayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
@RestController
@CrossOrigin
public class CfstVcrController {
	
private static final Logger logger = LoggerFactory.getLogger(CfstVcrController.class);
	
	@Autowired
	private  CfstVcrService cfstVcrService;
	
	@Autowired
	private AppMessages appMessages;
	

	
	@PostMapping(value = "getVcrDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> getVcrDetails(@RequestBody VcrInputVo vcrInputVo) {
		
		if(vcrInputVo.getDocumentType().isEmpty() ||vcrInputVo.getDocumentType()==null ){
			return new GateWayResponse<>(HttpStatus.BAD_REQUEST,appMessages.getResponseMessage(MessageKeys.CARDPRINT_INVALIDINPUTS));
		}
		
		if(vcrInputVo!=null){
			try {
				if(vcrInputVo.getRegNo()!=null){
					logger.info("requset received for vcr details for prNo: [{}]",vcrInputVo.getRegNo());
				}
				   
				List<org.epragati.cfstVcr.vo.VcrBookingData> vcrDetails = cfstVcrService.getVcrDetails(vcrInputVo);
				if(!CollectionUtils.isEmpty(vcrDetails)){
					return new GateWayResponse<>(HttpStatus.OK,vcrDetails,appMessages.getResponseMessage(MessageKeys.MESSAGE_SUCCESS));	
				}
				return new GateWayResponse<>(HttpStatus.NOT_FOUND,appMessages.getResponseMessage(MessageKeys.MESSAGE_NO_RECORD_FOUND));	
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return new GateWayResponse<>(HttpStatus.BAD_REQUEST,appMessages.getResponseMessage(MessageKeys.CARDPRINT_INVALIDINPUTS));	
	}
	@GetMapping(value = "getVcrTaxPaidDeatils", produces = { MediaType.APPLICATION_JSON_VALUE })
	public GateWayResponse<?> getTaxPaidVCRDetails(@RequestParam String regnPrNo) {
		if(!StringUtils.isEmpty(regnPrNo)){
			logger.info("requset received for vcr details for prNo: [{}]",regnPrNo);
		}
		
		Optional<TaxPaidVCRDetailsVO> taxPaidDetails = cfstVcrService.getVCRDetailsTaxPaid(regnPrNo);
		return new GateWayResponse<>(HttpStatus.OK,taxPaidDetails.get(),appMessages.getResponseMessage(MessageKeys.MESSAGE_SUCCESS));	
		
	}
 
	@GetMapping(value = "vcrCfstSearchTest", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 public GateWayResponse<?> getWarUpStatus(@RequestHeader("Authorization") String authString) {
		
		if(StringUtils.isNoneEmpty(authString)){
			if(authString.equals("Abcdf77878RhhghJyghjgUhsdhgshfgN")){
				return new GateWayResponse<>(HttpStatus.OK, "Success");
			}
		}
		return new GateWayResponse<>(HttpStatus.OK, "UnAuthorized Requset");
	}

	
}
