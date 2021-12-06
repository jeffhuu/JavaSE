import com.jeff.config.kuangConfig;
import com.jeff.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: demo
 * @description:
 * @author: Jack Hu 2021/07/07 14:33
 */
public class myTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(kuangConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());

    }
}
