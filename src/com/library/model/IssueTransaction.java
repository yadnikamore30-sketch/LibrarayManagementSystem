package com.library.model;
import java.sql.Date;

    public class IssueTransaction {
        private int transaction_id;
        private int book_id;
        private int reader_id;
        private Date issue_Date;
        private Date return_Date;
        private String status;

        public IssueTransaction(int transaction_id, int book_id, int reader_id, Date issue_Date, Date return_Date, String status) {
            this.transaction_id = transaction_id;
            this.book_id = book_id;
            this.reader_id = reader_id;
            this.issue_Date = issue_Date;
            this.return_Date = return_Date;
            this.status = status;
        }

        public int getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
        }

        public int getBook_id() {
            return book_id;
        }

        public void setBook_id(int book_id) {
            this.book_id = book_id;
        }

        public int getReader_id() {
            return reader_id;
        }

        public void setReader_id(int reader_id) {
            this.reader_id = reader_id;
        }

        public Date getIssue_Date() {
            return issue_Date;
        }

        public void setIssue_Date(Date issue_Date) {
            this.issue_Date = issue_Date;
        }

        public Date getReturn_Date() {
            return return_Date;
        }

        public void setReturn_Date(Date return_Date) {
            this.return_Date = return_Date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "IssueTransaction{" +
                    "transaction_id=" + transaction_id +
                    ", book_id=" + book_id +
                    ", reader_id=" + reader_id +
                    ", issue_Date=" + issue_Date +
                    ", return_Date=" + return_Date +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

