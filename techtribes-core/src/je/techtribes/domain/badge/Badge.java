package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;

import java.util.Collection;

public interface Badge {

    public int getId();

    public String getName();

    public String getDescription();

    public int getOrder();

    public void setOrder(int order);

}
