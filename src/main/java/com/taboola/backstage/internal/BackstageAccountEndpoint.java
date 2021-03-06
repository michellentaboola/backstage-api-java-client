package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.dictionary.AudienceSegment;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:24 PM
 * By Taboola
 */
public interface BackstageAccountEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/users/current/allowed-accounts")
    @Headers("Content-Type: application/json")
    Results<Account> getUserAllowedAccounts(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/users/current/account")
    @Headers("Content-Type: application/json")
    Account getUserAccount(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/taboola-network/publishers")
    @Headers("Content-Type: application/json")
    Results<Account> getAvailablePublishersUnderTaboolaNetwork(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/audience_segments")
    @Headers("Content-Type: application/json")
    Results<AudienceSegment> getAllAudienceSegments(@Header("Authorization") String accessToken,
                                                    @Path("account_id") String accountId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/audience_segments/{country_code}")
    @Headers("Content-Type: application/json")
    Results<AudienceSegment> getSpecificCountryAudienceSegments(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("country_code") String countryCode) throws BackstageAPIException;
}
