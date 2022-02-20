//package com.springboot.dynamodb;
//
//import org.assertj.core.internal.bytebuddy.matcher.ElementMatcher;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.junit.runner.RunWith;
//import org.junit.Test;
//
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
//import com.springboot.dynamodb.models.ProductInfo;
//import com.springboot.dynamodb.repositories.ProductInfoRepository;
//import org.aspectj.lang.annotation.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = IntuitApplication.class)
//@WebAppConfiguration
//@ActiveProfiles("local")
//@TestPropertySource(properties = {
//        "amazon.dynamodb.endpoint=http://localhost:8000/",
//        "amazon.aws.accesskey=test1",
//        "amazon.aws.secretkey=test231" })
//public class IntuitApplicationTests {
//
//    private DynamoDBMapper dynamoDBMapper;
//
//    @Autowired
//    private AmazonDynamoDB amazonDynamoDB;
//
//    @Autowired
//    ProductInfoRepository repository;
//
//    private static final String EXPECTED_COST = "20";
//    private static final String EXPECTED_PRICE = "50";
//
//    @Before
//    public void setup() throws Exception {
//        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//
//        CreateTableRequest tableRequest = dynamoDBMapper
//                .generateCreateTableRequest(ProductInfo.class);
//        tableRequest.setProvisionedThroughput(
//                new ProvisionedThroughput(1L, 1L));
//        amazonDynamoDB.createTable(tableRequest);
//
//        //...
//
//        dynamoDBMapper.batchDelete(
//                (List<ProductInfo>)repository.findAll());
//    }
//
//    @Test
//    public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
//        ProductInfo productInfo = new ProductInfo("1", EXPECTED_COST, EXPECTED_PRICE);
//        repository.save(productInfo);
//        List<ProductInfo> result = (List<ProductInfo>) repository.findAll();
//
//        assertThat(result.size(), is(greaterThan(0)));
//        assertThat(result.get(0).getCost(), is(equalTo(EXPECTED_COST)));
//    }
//
//
//
//}