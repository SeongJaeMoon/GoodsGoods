package goods.cap.app.goodsgoods.Helper;

import goods.cap.app.goodsgoods.Model.DietDtlResponseModel;

public interface DietDtlHelper {
    public abstract void success(DietDtlResponseModel response);
    public abstract void failure(String message);
}
