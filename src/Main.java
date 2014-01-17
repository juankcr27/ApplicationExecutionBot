import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;

public class Main {

	private ScriptingContainer ruby;

	public static void main(String[] args) throws FileNotFoundException {
		new Main().run();
	}

	public void run() throws FileNotFoundException {
		ruby = new ScriptingContainer(LocalVariableBehavior.PERSISTENT); 
		// Execute a script (can be of any length, and taken from a file)
		List<String> elements = new ArrayList<String>();
		elements.add("Juanito");
		elements.add("Mora");
		File rubyScript = new File("problem.rb");
		InputStream inputStr = new FileInputStream(rubyScript);
		StringBuilder text = new StringBuilder();
		for(String i: elements){
			text.append(i + "\n");
		}
		StringReader inputData = new StringReader(text.toString());
		BufferedReader reader = new BufferedReader(inputData);
		ruby.setReader(reader);
		ruby.runScriptlet(inputStr, "problem.rb");
	}
}