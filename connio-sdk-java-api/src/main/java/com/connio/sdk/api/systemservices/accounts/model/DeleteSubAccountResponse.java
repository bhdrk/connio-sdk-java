package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class DeleteSubAccountResponse extends AccountEndpointResponse<DeleteSubAccountResponse.Result> {

    public static class Result {

        /**
         * TODO: javadoc
         */
        private boolean deleted;

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }
    }

    private Result result;

    public DeleteSubAccountResponse(Result result) {
        this.result = result;
    }

    @Override
    public Class<Result> getResultType() {
        return Result.class;
    }

    @Override
    public Result getResult() {
        return result;
    }

    @Override
    public void setResult(Result result) {
        this.result = result;
    }
}
