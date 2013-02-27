package denominator.model.rdata;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;
import java.util.Map;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;

/**
 * Corresponds to the binary representation of the {@code AAAA} (Address) RData
 * 
 * <h4>Example</h4>
 * 
 * <pre>
 * AAAAData rdata = AAAAData.create("1234:ab00:ff00::6b14:abcd");
 * </pre>
 * 
 * @see <aaaa href="http://www.ietf.org/rfc/rfc3596.txt">RFC 3596</aaaa>
 */
public class AAAAData extends ForwardingMap<String, Object> {

    public static AAAAData create(String address) {
        return new AAAAData(address);
    }

    @ConstructorProperties("address")
    private AAAAData(String address) {
        this.delegate = ImmutableMap.<String, Object> of("address", checkNotNull(address, "address"));
    }

    /**
     * a 128 bit IPv6 address
     */
    public String getAddress() {
        return get("address").toString();
    }

    private final ImmutableMap<String, Object> delegate;
    
    @Override
    protected Map<String, Object> delegate() {
        return delegate;
    }
}