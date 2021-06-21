package io.devopsbox.yavaconf.sdk;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;
import software.amazon.awssdk.services.s3.model.PutBucketTaggingRequest;
import software.amazon.awssdk.services.s3.model.Tag;
import software.amazon.awssdk.services.s3.model.Tagging;

public class S3Bucket {
    public static void main(String[] args) {
        S3Client s3Client = S3Client.create();

        String bucketName = "yavaconf-sdk1";

        try {
            s3Client.headBucket(HeadBucketRequest.builder()
                    .bucket(bucketName)
                    .build());
        } catch (NoSuchBucketException e) {
            s3Client.createBucket(CreateBucketRequest.builder()
                    .bucket(bucketName)
                    .build());
        }

        s3Client.putBucketTagging(PutBucketTaggingRequest.builder()
                .bucket(bucketName)
                .tagging(Tagging.builder()
                        .tagSet(
                                Tag.builder()
                                        .key("Environment")
                                        .value("prod")
                                        .build()
                        )
                        .build())
                .build());

        s3Client.deleteBucket(DeleteBucketRequest.builder()
                .bucket(bucketName)
                .build());
    }
}
