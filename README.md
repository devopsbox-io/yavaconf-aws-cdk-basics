# Prerequisites

- AWS CLI (tested with 1.19.33)
- Terraform (tested with 0.14.3)
- AWS CDK (tested with 1.109.0)
- Java JDK (tested with openjdk 11.0.11)
- NodeJS (required by AWS CDK, tested with v12.18.3)
- Maven (tested with 3.6.3)

Should work with different versions of some prerequisites.

# What's inside?

- `src/main/java/io/devopsbox/yavaconf/sdk/S3Bucket.java` S3 bucket created/updated/deleted using AWS SDK
- `cloudformation` sample CloudFormation template and two bash scripts: deploy-cfn and delete-cfn
- `terraform` Terraform code that creates an S3 bucket
- `src/main/java/io/devopsbox/yavaconf/cdk/YavaconfAwsCdkBasicsStack.java` start here for code that uses AWS CDK

# Running

## AWS SDK

Run as a normal Java main for example from you IDE

## CloudFormation

```shell script
cd cloudformation
./deploy-cfn
```

## Terraform

```shell script
cd terraform
terraform apply
```

## AWS CDK

```shell script
cdk deploy
```

# Destroying

## CloudFormation

```shell script
cd cloudformation
./delete-cfn
```

## Terraform

```shell script
cd terraform
terraform destroy
```

## AWS CDK

```shell script
cdk destroy
```
