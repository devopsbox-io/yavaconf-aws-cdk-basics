package io.devopsbox.yavaconf.cdk.construct;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.s3.BucketProps;

public class EncryptedBucket extends Construct {
    public EncryptedBucket(Construct scope, String id, String bucketName) {
        super(scope, id);

        new Bucket(this, "bucket", BucketProps.builder()
                .bucketName(bucketName)
                .removalPolicy(RemovalPolicy.DESTROY)
                .encryption(BucketEncryption.KMS_MANAGED)
                .build());
    }
}
