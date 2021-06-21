package io.devopsbox.yavaconf.cdk.construct;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.s3.deployment.BucketDeployment;
import software.amazon.awscdk.services.s3.deployment.BucketDeploymentProps;
import software.amazon.awscdk.services.s3.deployment.Source;

import java.util.Collections;

public class HelloWorldWebsite extends Construct {
    private final String websiteUrl;

    public HelloWorldWebsite(Construct scope, String id) {
        super(scope, id);

        Bucket bucket = new Bucket(this, "bucket", BucketProps.builder()
                .removalPolicy(RemovalPolicy.DESTROY)
                .autoDeleteObjects(true)
                .publicReadAccess(true)
                .websiteIndexDocument("index.html")
                .build());

        new BucketDeployment(this, "website", BucketDeploymentProps.builder()
                .destinationBucket(bucket)
                .sources(Collections.singletonList(
                        Source.asset("src/main/resources/hello-site")
                ))
                .build());

        this.websiteUrl = bucket.getBucketWebsiteUrl();
    }

    public String getUrl() {
        return websiteUrl;
    }
}
