package com.ecommerce.be_ecommerce.model;

public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;
    private String stripepayPaymentLinkId;
    private String stripepayPaymentLinkReferenceId;
    private String stripepayPaymentLinkStatus;
    private String stripepayPaymentId;
     public PaymentDetails() {

     }

    public PaymentDetails(String paymentMethod, String status, String paymentId, String stripepayPaymentLinkId, String stripepayPaymentLinkReferenceId, String stripepayPaymentLinkStatus, String stripepayPaymentId) {
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentId = paymentId;
        this.stripepayPaymentLinkId = stripepayPaymentLinkId;
        this.stripepayPaymentLinkReferenceId = stripepayPaymentLinkReferenceId;
        this.stripepayPaymentLinkStatus = stripepayPaymentLinkStatus;
        this.stripepayPaymentId = stripepayPaymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStripepayPaymentLinkId() {
        return stripepayPaymentLinkId;
    }

    public void setStripepayPaymentLinkId(String stripepayPaymentLinkId) {
        this.stripepayPaymentLinkId = stripepayPaymentLinkId;
    }

    public String getStripepayPaymentLinkReferenceId() {
        return stripepayPaymentLinkReferenceId;
    }

    public void setStripepayPaymentLinkReferenceId(String stripepayPaymentLinkReferenceId) {
        this.stripepayPaymentLinkReferenceId = stripepayPaymentLinkReferenceId;
    }

    public String getStripepayPaymentLinkStatus() {
        return stripepayPaymentLinkStatus;
    }

    public void setStripepayPaymentLinkStatus(String stripepayPaymentLinkStatus) {
        this.stripepayPaymentLinkStatus = stripepayPaymentLinkStatus;
    }

    public String getStripepayPaymentId() {
        return stripepayPaymentId;
    }

    public void setStripepayPaymentId(String stripepayPaymentId) {
        this.stripepayPaymentId = stripepayPaymentId;
    }
}
