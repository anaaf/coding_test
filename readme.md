# Transaction Reader (Service Repository Architecture)

# Overview

This project implements a Transaction Reader Service Repository, designed to fetch financial transactions. It provides a flexible architecture for reading, storing, and processing transaction data efficiently. The architecture is structured around key components:

* Reader: Responsible for reading transaction data from various sources, such as files, databases, or APIs.

* DataStore: An abstraction over a data source

* Mapper: Reponsibile to map json objects to data model

* Service: Manages the core business logic for processing transactions, data transformation, adapting data to the conusiming needs, including validation, enrichment, and aggregation.

* Repository: Handles the storage, retrieval, filtering, quering of transaction data, ensuring data integrity.

This project follows solid and clean code practices to make software maintainable, extensible, readable and loosely coupled (dependency on interfaces not implementation)

# Methods Implemented
  * double GetTotalTransactionAmount();
  * double GetTotalTransactionAmountSentBy(String senderFullName);
  * double GetMaxTransactionAmount();
  * Map<String, Double> GetTopSender();
  * List<Transaction> GetTop3TransactionsByAmount();
  * long CountUniqueClients();
  * List<String> GetResolvedIssueMessages();
  * Set<Integer> GetUnResolvedIssuesId();
  * Map<String, List<Transaction>>GetTransactionByBeneficiaryName();
  * boolean GetTransactionWithComplianceIssue(String clientName);

# Technologies
  * Java

# Unit Test

This project contains unit test for repository and service layer. Service layer contains unit test where some transformation or business logic is presented but not all units in service layer. Also some unit in repository doesnot have test because that logic is tested in service layer unit tests.

# Key Points
  * [Dependency Injection not used] As this is barebone java project so DI is not implemented because by adding spring dependency on it to use dependency container will be a overkill for this project.

----------------------------------------------------------------------------------------------------------------

# Welcome to our coding test!

Your solution to this coding test will be evaluated based on its:
 * Adherence to best coding practices
 * Correctness
 * Efficiency

Take your time to fully understand the problem and formulate a plan before starting to code, and don't hesitate to ask any questions if you have doubts.

# Objective

Since we are a money transfer company this test will revolve around a (very) simplified transaction model. Our aim is to implement the methods listed in `com.smallworld.TransactionDataFetcher`, a component that allows us to get some insight into the transactions our system has.

A battery of test transactions is stored in `transactions.json` that is going to be used as a datasource for all our data mapping needs.

Each entry in `transactions.json` consists of:
 * mtn: unique identifier of the transaction
 * amount
 * senderFullName, senderAge: sender information
 * beneficiaryFullName, beneficiaryAge: beneficiary information
 * issueId, issueSolved, issueMessage: issue information. Transactions can:
   * Contain no issues: in this case, issueId = null.
   * Contain a list of issues: in this case, the transaction information will be repeated in different entries in `transactions.json` changing the issue related information.

Each method to be implemented includes a brief description of what's expected of it.

The parameters and return types of each method can be modified to fit the model that contains the transaction information

Have fun!