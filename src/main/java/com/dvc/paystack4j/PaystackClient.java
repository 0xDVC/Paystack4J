package com.dvc.paystack4j;

import com.dvc.paystack4j.common.RequestExecutor;
import com.dvc.paystack4j.core.*;

public interface PaystackClient {
    ApplePay applePay();
    BulkCharges bulkCharges();
    Charge charge();
    Customers customers();
    DedicatedVirtualAccounts dedicatedVirtualAccounts();
    Disputes disputes();
    Integration integrations();
    Miscellaneous miscellaneous();
    PaymentPages paymentPages();
    PaymentRequests paymentRequests();
    Plans plans();
    Products products();
    Refunds refunds();
    Settlements settlements();
    SubAccounts subAccounts();
    Subscriptions subscriptions();
    Transactions transactions();
    Transfers transfers();
    TransfersControl transfersControl();
    Terminal terminal();
    TransactionSplit transactionSplit();
    TransfersRecipient transfersRecipient();
    Verification verification();

    final class Impl implements PaystackClient {
        public Impl(String secretKey) {
            RequestExecutor.setKey(secretKey);
        }

        public ApplePay applePay() {
            return new ApplePay();
        }

        public BulkCharges bulkCharges() {
            return new BulkCharges();
        }

        public Charge charge() {
            return new Charge();
        }

        public Customers customers() {
            return new Customers();
        }

        public DedicatedVirtualAccounts dedicatedVirtualAccounts() {
            return new DedicatedVirtualAccounts();
        }

        public Disputes disputes() {
            return new Disputes();
        }

        public Integration integrations() {
            return new Integration();
        }

        public Miscellaneous miscellaneous() {
            return new Miscellaneous();
        }

        public PaymentPages paymentPages() {
            return new PaymentPages();
        }

        public PaymentRequests paymentRequests() {
            return new PaymentRequests();
        }

        public Plans plans() {
            return new Plans();
        }

        public Products products() {
            return new Products();
        }

        public Refunds refunds() {
            return new Refunds();
        }

        public Settlements settlements() {
            return new Settlements();
        }

        public SubAccounts subAccounts() {
            return new SubAccounts();
        }

        public Subscriptions subscriptions() {
            return new Subscriptions();
        }

        public Transactions transactions() {
            return new Transactions();
        }

        public Transfers transfers() {
            return new Transfers();
        }

        public TransfersControl transfersControl() {
            return new TransfersControl();
        }

        public Terminal terminal() {
            return new Terminal();
        }

        public TransactionSplit transactionSplit() {
            return new TransactionSplit();
        }

        public TransfersRecipient transfersRecipient() {
            return new TransfersRecipient();
        }

        public Verification verification() {
            return new Verification();
        }

    }
}
