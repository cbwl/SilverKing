package com.ms.silverking.cloud.dht.common;

import java.util.Set;

import com.ms.silverking.cloud.dht.ConsistencyProtocol;
import com.ms.silverking.cloud.dht.GetOptions;
import com.ms.silverking.cloud.dht.InvalidationOptions;
import com.ms.silverking.cloud.dht.NamespaceOptions;
import com.ms.silverking.cloud.dht.NamespaceVersionMode;
import com.ms.silverking.cloud.dht.NonExistenceResponse;
import com.ms.silverking.cloud.dht.PutOptions;
import com.ms.silverking.cloud.dht.RetrievalOptions;
import com.ms.silverking.cloud.dht.RetrievalType;
import com.ms.silverking.cloud.dht.RevisionMode;
import com.ms.silverking.cloud.dht.SecondaryTarget;
import com.ms.silverking.cloud.dht.StorageType;
import com.ms.silverking.cloud.dht.TimeoutResponse;
import com.ms.silverking.cloud.dht.VersionConstraint;
import com.ms.silverking.cloud.dht.WaitMode;
import com.ms.silverking.cloud.dht.WaitOptions;
import com.ms.silverking.cloud.dht.client.OpTimeoutController;
import com.ms.silverking.cloud.dht.net.ForwardingMode;

/**
 * This class contains helper methods to construct options. End-users should
 * construct options from the options hierarchy. Some code, however, needs to
 * conveniently construct from scratch. Other code was written before the
 * hierarchy was in place. This class moves this code out of the options classes
 * themselves so that this is hidden from end users.
 */
public class OptionsHelper {

    /////////////////////
    // RetrievalOptions

    /**
     * Construct a RetrievalOptions instance that is fully-specified with the
     * exception of forwardingMode which is set to FORWARD for normal operation
     * and OpTimeoutController, and updateSecondariesOnMiss which is set to
     * false.
     * 
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     * @param versionConstraint
     *            specify the version
     * @param nonExistenceResponse
     *            action to perform for non-existent keys
     * @param verifyChecksums
     *            whether or not to verify checksums
     */
    public static RetrievalOptions newRetrievalOptions(
            RetrievalType retrievalType, WaitMode waitMode,
            VersionConstraint versionConstraint,
            NonExistenceResponse nonExistenceResponse, boolean verifyChecksums) {
        return new RetrievalOptions(
                waitMode == WaitMode.GET ? DHTConstants.standardTimeoutController
                        : DHTConstants.standardWaitForTimeoutController,
                DHTConstants.noSecondaryTargets, retrievalType, waitMode,
                versionConstraint, nonExistenceResponse, verifyChecksums,
                false, ForwardingMode.FORWARD, false, DHTConstants.noUserOptions);
    }

    /**
     * Construct RetrievalOptions with null values returned for non-existent
     * keys and checksumVerification on
     * 
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     * @param versionConstraint
     *            specify the version
     */
    /*
    public static RetrievalOptions newRetrievalOptions(
            OpTimeoutController opTimeoutController,
            RetrievalType retrievalType, WaitMode waitMode,
            VersionConstraint versionConstraint) {
        return new RetrievalOptions(opTimeoutController, retrievalType,
                waitMode, versionConstraint,
                NonExistenceResponse.defaultResponse, true, false,
                ForwardingMode.FORWARD, false, null);
    }
    */
    

    /**
     * Construct RetrievalOptions with null values returned for non-existent
     * keys and checksumVerification on
     * 
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     * @param versionConstraint
     *            specify the version
     */
    public static RetrievalOptions newRetrievalOptions(
            RetrievalType retrievalType, WaitMode waitMode,
            VersionConstraint versionConstraint) {
        return newRetrievalOptions(retrievalType, waitMode, versionConstraint,
                NonExistenceResponse.defaultResponse, true);
    }

    /**
     * Construct RetrievalOptions with null values returned for non-existent
     * keys and checksumVerification on
     * 
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     * @param versionConstraint
     *            specify the version
     * @param secondaryTargets
     *            constrains queried secondary replicas
     */
    public static RetrievalOptions newRetrievalOptions(
            RetrievalType retrievalType, WaitMode waitMode,
            VersionConstraint versionConstraint,
            boolean updateSecondariesOnMiss,
            Set<SecondaryTarget> secondaryTargets) {
        return new RetrievalOptions(
                waitMode == WaitMode.GET ? DHTConstants.standardTimeoutController
                        : DHTConstants.standardWaitForTimeoutController,
                secondaryTargets, retrievalType, waitMode,
                versionConstraint, NonExistenceResponse.defaultResponse, true,
                false, ForwardingMode.FORWARD,
                updateSecondariesOnMiss, DHTConstants.noUserOptions);
    }

    /**
     * Construct RetrievalOptions with null values returned for non-existent
     * keys and checksumVerification on
     *
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     * @param versionConstraint
     *            specify the version
     * @param secondaryTargets
     *            constrains queried secondary replicas
     * @param userOptions
     *            additional side data options from user
     */
    public static RetrievalOptions newRetrievalOptions(
            RetrievalType retrievalType, WaitMode waitMode,
            VersionConstraint versionConstraint,
            boolean updateSecondariesOnMiss,
            Set<SecondaryTarget> secondaryTargets,
            byte[] userOptions
    ) {
        return new RetrievalOptions(
                waitMode == WaitMode.GET ? DHTConstants.standardTimeoutController
                        : DHTConstants.standardWaitForTimeoutController,
                secondaryTargets, retrievalType, waitMode,
                versionConstraint, NonExistenceResponse.defaultResponse, true,
                false, ForwardingMode.FORWARD,
                updateSecondariesOnMiss, userOptions);
    }

    /**
     * Construct RetrievalOptions with VersionConstraint set to return the
     * greatest version, null values returned for non-existent keys, and
     * checksumVerification on.
     * 
     * @param retrievalType
     *            type of retrieval
     * @param waitMode
     *            whether to perform a WaitFor or a Get
     */
    public static RetrievalOptions newRetrievalOptions(
            RetrievalType retrievalType, WaitMode waitMode) {
        return newRetrievalOptions(retrievalType, waitMode,
                VersionConstraint.defaultConstraint);
    }

    
    ///////////////
    // GetOptions

    public static GetOptions newGetOptions(OpTimeoutController opTimeoutController,
                                        RetrievalType retrievalType, VersionConstraint versionConstraint) {
        return new GetOptions(opTimeoutController, DHTConstants.noSecondaryTargets, retrievalType,
                versionConstraint, NonExistenceResponse.defaultResponse, true, false, ForwardingMode.FORWARD, false, DHTConstants.noUserOptions);
    }

    public static GetOptions newGetOptions(RetrievalType retrievalType, VersionConstraint versionConstraint) {
        return newGetOptions(DHTConstants.standardTimeoutController, retrievalType,
                versionConstraint);
    }

    public static GetOptions newGetOptions(RetrievalType retrievalType) {
        return newGetOptions(retrievalType, VersionConstraint.defaultConstraint);
    }

    
    ////////////////
    // WaitOptions

    
    /**
     * Construct fully-specified static WaitOptions newWaitOptions except for OpTimeoutController which will use the default.
     * @param retrievalType what to retrieve (data, meta data, etc.)
     * @param versionConstraint filter on the allowed versions
     * @param timeoutSeconds return after timeoutSeconds if the values cannot be retrieved
     * @param threshold return after a percentage of requested values are available
     * @param timeoutResponse specifies whether or not to throw an exception when a timeout occurs before all
     * of the requested values could be retrieved
     */
    public static WaitOptions newWaitOptions(RetrievalType retrievalType, VersionConstraint versionConstraint,
                       int timeoutSeconds, int threshold, TimeoutResponse timeoutResponse) {
        return new WaitOptions(DHTConstants.standardWaitForTimeoutController, DHTConstants.noSecondaryTargets,
                       retrievalType, versionConstraint, 
                       NonExistenceResponse.defaultResponse, true,
                       false,
                       false, DHTConstants.noUserOptions, timeoutSeconds,
                       threshold,
                       timeoutResponse);
    }

    /**
     * Construct static WaitOptions newWaitOptions with timeoutResponse set to the default of throwing an exception upon timeout.
     * @param retrievalType what to retrieve (data, meta data, etc.)
     * @param versionConstraint filter on the allowed versions
     * @param timeoutSeconds return after timeoutSeconds if the values cannot be retrieved
     * @param threshold return after a percentage of requested values are available
     */
    public static WaitOptions newWaitOptions(RetrievalType retrievalType, VersionConstraint versionConstraint,
            int timeoutSeconds, int threshold) {
        return newWaitOptions(retrievalType, versionConstraint, timeoutSeconds, threshold, TimeoutResponse.defaultResponse);
    }
    
    /**
     * Construct static WaitOptions newWaitOptions with timeoutResponse set to the default of throwing an exception upon timeout,
     * and threshold set to require all values before returning
     * @param retrievalType what to retrieve (data, meta data, etc.)
     * @param versionConstraint filter on the allowed versions
     * @param timeoutSeconds return after timeoutSeconds if the values cannot be retrieved
     */
    public static WaitOptions newWaitOptions(RetrievalType retrievalType, VersionConstraint versionConstraint, int timeoutSeconds) {
        return newWaitOptions(retrievalType, versionConstraint, timeoutSeconds, WaitOptions.THRESHOLD_MAX);
    }
    
    /**
     * Construct static WaitOptions newWaitOptions specifying to wait forever until all values are returned, and using the
     * default VersionConstraint of the greatest of all available versions
     * @param retrievalType what to retrieve (data, meta data, etc.)
     */
    public static WaitOptions newWaitOptions(RetrievalType retrievalType) {
        return newWaitOptions(retrievalType, VersionConstraint.defaultConstraint, WaitOptions.NO_TIMEOUT);
    }
    
    /**
     * Construct static WaitOptions newWaitOptions for RetrievalType.VALUE specifying to wait forever until all values are returned, 
     * using the default VersionConstraint of the greatest of all available versions
     */
    public static WaitOptions newWaitOptions() {
        return newWaitOptions(RetrievalType.VALUE);
    }
    
    ///////////////
    // PutOptions
    
    public static InvalidationOptions newInvalidationOptions(OpTimeoutController opTimeoutController,
                                                        long version, long requiredPreviousVersion, Set<SecondaryTarget> secondaryTargets) {
        return new InvalidationOptions(opTimeoutController, secondaryTargets, version, requiredPreviousVersion);
    }
    
    /////////////////////
    // NamespaceOptions
    
    public static NamespaceOptions newNamespaceOptions(StorageType storageType,
            ConsistencyProtocol consistencyProtocol,
            NamespaceVersionMode versionMode, RevisionMode revisionMode,
            PutOptions defaultPutOptions,
            InvalidationOptions defaultInvalidationOptions,
            GetOptions defaultGetOptions, WaitOptions defaultWaitOptions,
            int secondarySyncIntervalSeconds, int segmentSize, int maxValueSize) {
        return new NamespaceOptions(storageType, consistencyProtocol, versionMode, revisionMode,
                defaultPutOptions, defaultInvalidationOptions,
                defaultGetOptions, defaultWaitOptions,
                secondarySyncIntervalSeconds, segmentSize, maxValueSize, false);
    }    
    
    public static NamespaceOptions newNamespaceOptions(StorageType storageType, ConsistencyProtocol consistencyProtocol, 
                            NamespaceVersionMode versionMode, 
                            PutOptions defaultPutOptions, InvalidationOptions defaultInvalidationOptions,
                            GetOptions defaultGetOptions, WaitOptions defaultWaitOptions) {
        return new NamespaceOptions(storageType, consistencyProtocol, versionMode, DHTConstants.defaultRevisionMode, 
                                    defaultPutOptions, defaultInvalidationOptions, 
                                    defaultGetOptions, defaultWaitOptions, DHTConstants.defaultSecondarySyncIntervalSeconds, 
                                    DHTConstants.defaultSegmentSize, DHTConstants.defaultMaxValueSize, false);
    }    
}
