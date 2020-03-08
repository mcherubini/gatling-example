### Launch API

Node 13.10.1 is required

After installing package.json dependencies, you can run api with the command:

``` bash
npm run start
```

### Launch Gatling

Maven 3.6.3 is required

You can launch Gatling report with the command:

```bash
mvn clean gatling:test
```
### Launch JMeter
 
 Jmeter 5.1.1 is required and **Plugin Manager** installed with plugin **Parallel Controller & Sampler**

 You can use the next command to generate the web report:

``` bash
jmeter -n -t [jmx file path] -l [results file path] -e -o [web report path]
```

If you want to change JMeter data format in report file, just override the properties in the jmeter file **user.properties** with the date format you want:

``` bash
jmeter.save.saveservice.timestamp_format=yyyy/MM/dd HH:mm:ss.SSS
```