package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateAuthenticationTokenResponse extends AccountEndpointResponse<CreateAuthenticationTokenResponse.Result> {

    public static class Result {
        /**
         * TODO: javadoc
         */
        private String authToken;

        public String getAuthToken() {
            return authToken;
        }

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }
    }

    private Result result;

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
