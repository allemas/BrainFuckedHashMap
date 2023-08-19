import junit.framework.TestCase;
import org.example.myhash.BrainFuckedHash;
import org.example.myhash.ExperimentalKey;
import org.junit.Assert;
import org.junit.Test;

public class BrainFuckedHashMapTest extends TestCase {

    @Test
    public void testCreateBrainFuckedHashMap() throws Exception {
        BrainFuckedHash brainFuckedHash = new BrainFuckedHash<String, String>();
        String t = (String) brainFuckedHash.add("toto", "tata");
        String t2 = (String) brainFuckedHash.add("toto", "tata");
        String val = (String) brainFuckedHash.get("toto");

        Assert.assertEquals(t, val);
    }

    @Test
    public void testExperimentalKey() throws Exception {
        BrainFuckedHash brainFuckedHash = new BrainFuckedHash<ExperimentalKey, String>();
        brainFuckedHash.add(new ExperimentalKey("toto"), "sdfsd");
        brainFuckedHash.add(new ExperimentalKey("ta"), "sdfsd");

        String d = (String) brainFuckedHash.get(new ExperimentalKey("ta"));
        Assert.assertEquals(d, "sdfsd");
    }
}
