package goods.cap.app.goodsgoods.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class RequestParam {

    @Element(name = "dietSeCode", required = false)
    private String dietSeCode;
}
