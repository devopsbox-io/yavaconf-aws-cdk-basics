package io.devopsbox.yavaconf.cdk;

import software.amazon.awscdk.core.CfnTag;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.core.Tags;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.s3.CfnBucket;
import software.amazon.awscdk.services.s3.CfnBucketProps;

import java.util.Arrays;

public class YavaconfAwsCdkBasicsStack extends Stack {
    public YavaconfAwsCdkBasicsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public YavaconfAwsCdkBasicsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        s3BucketUsingL1Construct();

        s3BucketUsingL2Construct();
    }

    private void s3BucketUsingL1Construct() {
        new CfnBucket(this, "yavaconf-l1", CfnBucketProps.builder()
                .bucketName("yavaconf-cdk-l1")
                .tags(Arrays.asList(
                        CfnTag.builder()
                                .key("Environment")
                                .value("prod")
                                .build()
                ))
                .build());
    }

    private void s3BucketUsingL2Construct() {
        Bucket l2Bucket = new Bucket(this, "yavaconf-l2", BucketProps.builder()
                .bucketName("yavaconf-cdk-l2")
                .removalPolicy(RemovalPolicy.DESTROY)
                .build());

        Tags.of(l2Bucket).add("Environment", "prod");
    }
}
