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
     * Default implementation of the PaystackClient interface.
     * This class provides concrete implementations of all Paystack API service endpoints.
     * It manages the API key configuration and instantiates service objects on demand.
     *
     * <p>This implementation is thread-safe and services are created as lightweight objects
     * when requested rather than being held in memory.</p>
     */
    final class Impl implements PaystackClient {

        /**
         * Creates a new PaystackClient implementation with the specified API key.
         * The key is stored securely in the RequestExecutor for all subsequent API calls.
         *
         * @param secretKey The Paystack secret key used for API authentication
         * @throws IllegalArgumentException if the secretKey is null or empty
         */
        public Impl(String secretKey) {
            RequestExecutor.setKey(secretKey);
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the ApplePay service for handling Apple Pay integrations
         */
        @Override
        public ApplePay applePay() {
            return new ApplePay();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the BulkCharges service for handling multiple transactions
         */
        @Override
        public BulkCharges bulkCharges() {
            return new BulkCharges();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Charge service for processing direct charges
         */
        @Override
        public Charge charge() {
            return new Charge();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Customers service for managing customer data
         */
        @Override
        public Customers customers() {
            return new Customers();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the DedicatedVirtualAccounts service for managing virtual accounts
         */
        @Override
        public DedicatedVirtualAccounts dedicatedVirtualAccounts() {
            return new DedicatedVirtualAccounts();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Disputes service for handling transaction disputes
         */
        @Override
        public Disputes disputes() {
            return new Disputes();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Integration service for managing integration settings
         */
        @Override
        public Integration integrations() {
            return new Integration();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Miscellaneous service for auxiliary operations
         */
        @Override
        public Miscellaneous miscellaneous() {
            return new Miscellaneous();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the PaymentPages service for managing payment pages
         */
        @Override
        public PaymentPages paymentPages() {
            return new PaymentPages();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the PaymentRequests service for handling payment requests
         */
        @Override
        public PaymentRequests paymentRequests() {
            return new PaymentRequests();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Plans service for managing subscription plans
         */
        @Override
        public Plans plans() {
            return new Plans();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Products service for managing product catalog
         */
        @Override
        public Products products() {
            return new Products();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Refunds service for processing refunds
         */
        @Override
        public Refunds refunds() {
            return new Refunds();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Settlements service for managing settlements
         */
        @Override
        public Settlements settlements() {
            return new Settlements();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the SubAccounts service for managing sub-accounts
         */
        @Override
        public SubAccounts subAccounts() {
            return new SubAccounts();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Subscriptions service for managing recurring billing
         */
        @Override
        public Subscriptions subscriptions() {
            return new Subscriptions();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Transactions service for processing transactions
         */
        @Override
        public Transactions transactions() {
            return new Transactions();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Transfers service for managing transfers
         */
        @Override
        public Transfers transfers() {
            return new Transfers();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the TransfersControl service for transfer management
         */
        @Override
        public TransfersControl transfersControl() {
            return new TransfersControl();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Terminal service for POS operations
         */
        @Override
        public Terminal terminal() {
            return new Terminal();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the TransactionSplit service for split payments
         */
        @Override
        public TransactionSplit transactionSplit() {
            return new TransactionSplit();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the TransfersRecipient service for managing transfer recipients
         */
        @Override
        public TransfersRecipient transfersRecipient() {
            return new TransfersRecipient();
        }

        /**
         * {@inheritDoc}
         * @return A new instance of the Verification service for identity verification
         */
        @Override
        public Verification verification() {
            return new Verification();
        }
    }
}
