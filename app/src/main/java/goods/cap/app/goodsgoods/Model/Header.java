package goods.cap.app.goodsgoods.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Header {
    @Element(name = "resultCode", required = false)
    private String resultCode;
    @Element(name = "resultMsg", required = false)
    private String resultMsg;
    @Element(name = "requestParameter", required = false)
    private RequestParam RequestParam;
}
