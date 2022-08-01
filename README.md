# devopsdays-cranker-router

A demo project for 2022 DevOpsDays Guangzhou.

## Run from local

Basically what you need is run `RunLocalCranker.java`

### If dependency `cranker-connector` is missing

```xml
    <dependency>
    <groupId>com.hsbc.cranker</groupId>
    <artifactId>mu-cranker-router</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Up to 2022-08-02, the **mu-cranker-router** haven't been published to central maven repository. To use it, you may need to clone and build it from local first. below is the steps

1. `git clone https://github.com/hsbc/mu-cranker-router.git`
2. `cd mu-cranker-router && mvn clean install`

After that, the demo project should be able to be built and run.
