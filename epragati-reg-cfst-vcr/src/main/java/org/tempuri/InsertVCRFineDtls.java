
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VCR_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Regn_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Challan_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Transaction_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Transaction_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Transaction_Dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vcrNo",
    "regnNo",
    "challanNo",
    "transactionNo",
    "transactionAmount",
    "transactionDt",
    "paymentDt"
})
@XmlRootElement(name = "InsertVCRFineDtls")
public class InsertVCRFineDtls {

    @XmlElement(name = "VCR_No")
    protected String vcrNo;
    @XmlElement(name = "Regn_no")
    protected String regnNo;
    @XmlElement(name = "Challan_no")
    protected String challanNo;
    @XmlElement(name = "Transaction_no")
    protected String transactionNo;
    @XmlElement(name = "Transaction_Amount")
    protected String transactionAmount;
    @XmlElement(name = "Transaction_Dt")
    protected String transactionDt;
    @XmlElement(name = "Payment_Dt")
    protected String paymentDt;

    /**
     * Gets the value of the vcrNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCRNo() {
        return vcrNo;
    }

    /**
     * Sets the value of the vcrNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCRNo(String value) {
        this.vcrNo = value;
    }

    /**
     * Gets the value of the regnNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegnNo() {
        return regnNo;
    }

    /**
     * Sets the value of the regnNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegnNo(String value) {
        this.regnNo = value;
    }

    /**
     * Gets the value of the challanNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallanNo() {
        return challanNo;
    }

    /**
     * Sets the value of the challanNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallanNo(String value) {
        this.challanNo = value;
    }

    /**
     * Gets the value of the transactionNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * Sets the value of the transactionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNo(String value) {
        this.transactionNo = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAmount(String value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the transactionDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDt() {
        return transactionDt;
    }

    /**
     * Sets the value of the transactionDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDt(String value) {
        this.transactionDt = value;
    }

    /**
     * Gets the value of the paymentDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDt() {
        return paymentDt;
    }

    /**
     * Sets the value of the paymentDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDt(String value) {
        this.paymentDt = value;
    }

}
