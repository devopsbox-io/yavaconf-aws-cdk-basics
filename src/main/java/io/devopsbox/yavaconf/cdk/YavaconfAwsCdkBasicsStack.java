package io.devopsbox.yavaconf.cdk;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class YavaconfAwsCdkBasicsStack extends Stack {
    public YavaconfAwsCdkBasicsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public YavaconfAwsCdkBasicsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
    }
}
