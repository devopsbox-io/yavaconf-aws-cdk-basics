provider "aws" {
  region = "eu-west-1"
}

resource "aws_s3_bucket" "bucket" {
  bucket = "yavaconf-terraform"

  tags = {
    Environment = "prod"
  }
}
