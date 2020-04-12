import com.yzy.Application;
import com.yzy.rabbitMQ.RabbitProducer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    @Autowired
    private RabbitProducer producer;
    @org.junit.Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            producer.stringSend();
        }
        System.out.println(123);
    }
}
