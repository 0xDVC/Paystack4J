package com.dvc.paystack4j;

import com.dvc.paystack4j.common.RequestExecutor;
import com.dvc.paystack4j.core.ApplePay;
import com.dvc.paystack4j.core.BulkCharges;
import com.dvc.paystack4j.core.Charge;
import com.dvc.paystack4j.core.Customers;
import com.dvc.paystack4j.core.DedicatedVirtualAccounts;
import com.dvc.paystack4j.core.Disputes;
import com.dvc.paystack4j.core.Integration;
import com.dvc.paystack4j.core.Miscellaneous;
import com.dvc.paystack4j.core.PaymentPages;
import com.dvc.paystack4j.core.PaymentRequests;
import com.dvc.paystack4j.core.Plans;
import com.dvc.paystack4j.core.Products;
import com.dvc.paystack4j.core.Refunds;
import com.dvc.paystack4j.core.Settlements;
import com.dvc.paystack4j.core.SubAccounts;
import com.dvc.paystack4j.core.Subscriptions;
import com.dvc.paystack4j.core.Terminal;
import com.dvc.paystack4j.core.TransactionSplit;
import com.dvc.paystack4j.core.Transactions;
import com.dvc.paystack4j.core.Transfers;
import com.dvc.paystack4j.core.TransfersControl;
import com.dvc.paystack4j.core.TransfersRecipient;
import com.dvc.paystack4j.core.Verification;

/**
 * Primary interface for interacting with the Paystack API.
 * Provides access to all Paystack API endpoints through dedicated service objects.
 *
 * <p>To create a new instance, use the PaystackClientConfiguration:
 * <pre>{@code
 * PaystackClient client = PaystackClientConfiguration.buildClient(KeyType.LIVE);
 *
 * // Example usage:
 * Transaction transaction = client.transactions().verify("reference");
 * Customer customer = client.customers().create(new CustomerRequest("email@example.com"));
 * }</pre>
 */
public interface PaystackClient {
    /**
     * Access Apple Pay related operations.
     * @return ApplePay service instance
     */
    ApplePay applePay();

    /**
     * Access bulk charge operations for processing multiple transactions.
     * @return BulkCharges service instance
     */
    BulkCharges bulkCharges();

    /**
     * Access direct charge operations.
     * @return Charge service instance
     */
    Charge charge();

    /**
     * Access customer management operations.
     * @return Customers service instance
     */
    Customers customers();

    /**
     * Access dedicated virtual account operations.
     * @return DedicatedVirtualAccounts service instance
     */
    DedicatedVirtualAccounts dedicatedVirtualAccounts();

    /**
     * Access dispute management operations.
     * @return Disputes service instance
     */
    Disputes disputes();

    /**
     * Access integration settings and operations.
     * @return Integration service instance
     */
    Integration integrations();

    /**
     * Access miscellaneous API operations.
     * @return Miscellaneous service instance
     */
    Miscellaneous miscellaneous();

    /**
     * Access payment page management operations.
     * @return PaymentPages service instance
     */
    PaymentPages paymentPages();

    /**
     * Access payment request operations.
     * @return PaymentRequests service instance
     */
    PaymentRequests paymentRequests();

    /**
     * Access subscription plan management operations.
     * @return Plans service instance
     */
    Plans plans();

    /**
     * Access product catalog management operations.
     * @return Products service instance
     */
    Products products();

    /**
     * Access refund management operations.
     * @return Refunds service instance
     */
    Refunds refunds();

    /**
     * Access settlement operations and reports.
     * @return Settlements service instance
     */
    Settlements settlements();

    /**
     * Access subAccount management operations.
     * @return SubAccounts service instance
     */
    SubAccounts subAccounts();

    /**
     * Access subscription management operations.
     * @return Subscriptions service instance
     */
    Subscriptions subscriptions();

    /**
     * Access transaction operations and verification.
     * @return Transactions service instance
     */
    Transactions transactions();

    /**
     * Access transfer operations.
     * @return Transfers service instance
     */
    Transfers transfers();

    /**
     * Access transfer control operations.
     * @return TransfersControl service instance
     */
    TransfersControl transfersControl();

    /**
     * Access terminal and POS operations.
     * @return Terminal service instance
     */
    Terminal terminal();

    /**
     * Access transaction split operations.
     * @return TransactionSplit service instance
     */
    TransactionSplit transactionSplit();

    /**
     * Access transfer recipient management operations.
     * @return TransfersRecipient service instance
     */
    TransfersRecipient transfersRecipient();

    /**
     * Access verification operations for BVN, card, etc.
     * @return Verification service instance
     */
    Verification verification();

    /**
     * Implementation of the PaystackClient interface.
     * This class handles the actual creation of service instances and API key management.
     */

    final class Impl implements PaystackClient {
        public Impl(String secretKey) {
            RequestExecutor.setKey(secretKey);
        }

        @Override
        public ApplePay applePay() {
            return new ApplePay();
        }

        @Override
        public BulkCharges bulkCharges() {
            return new BulkCharges();
        }

        @Override
        public Charge charge() {
            return new Charge();
        }

        @Override
        public Customers customers() {
            return new Customers();
        }

        @Override
        public DedicatedVirtualAccounts dedicatedVirtualAccounts() {
            return new DedicatedVirtualAccounts();
        }

        @Override
        public Disputes disputes() {
            return new Disputes();
        }

        @Override
        public Integration integrations() {
            return new Integration();
        }

        @Override
        public Miscellaneous miscellaneous() {
            return new Miscellaneous();
        }

        @Override
        public PaymentPages paymentPages() {
            return new PaymentPages();
        }

        @Override
        public PaymentRequests paymentRequests() {
            return new PaymentRequests();
        }

        @Override
        public Plans plans() {
            return new Plans();
        }

        @Override
        public Products products() {
            return new Products();
        }

        @Override
        public Refunds refunds() {
            return new Refunds();
        }

        @Override
        public Settlements settlements() {
            return new Settlements();
        }

        @Override
        public SubAccounts subAccounts() {
            return new SubAccounts();
        }

        @Override
        public Subscriptions subscriptions() {
            return new Subscriptions();
        }

        @Override
        public Transactions transactions() {
            return new Transactions();
        }

        @Override
        public Transfers transfers() {
            return new Transfers();
        }

        @Override
        public TransfersControl transfersControl() {
            return new TransfersControl();
        }

        @Override
        public Terminal terminal() {
            return new Terminal();
        }

        @Override
        public TransactionSplit transactionSplit() {
            return new TransactionSplit();
        }

        @Override
        public TransfersRecipient transfersRecipient() {
            return new TransfersRecipient();
        }

        @Override
        public Verification verification() {
            return new Verification();
        }

    }
}
