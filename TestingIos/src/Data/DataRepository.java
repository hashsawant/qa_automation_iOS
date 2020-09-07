package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Helpers.ConfigFileReader;

public class DataRepository<T extends IDataLoader> {
	private String fileName;
	private ArrayList<T> repository;
	private ConfigFileReader fileReader = null;
	private Class<T> typeArgumentClass;

	@SuppressWarnings("unchecked")
	public DataRepository(T entity) throws Exception {
		this.typeArgumentClass = (Class<T>) entity.getClass();
		this.repository = new ArrayList<T>();
		// System.out.println("SizeofRepository:" + repository.size());
		if (fileReader == null) {
			fileReader = new ConfigFileReader();
			this.fileName = fileReader.getPlaceOrderDataFileName(entity.getFileName());
			System.out.println("FileName:" + fileName);
		}
	}

	public ArrayList<T> GetData(String dataPath) {
		Path pathOfFile = Paths.get(dataPath, fileName);
		// System.out.println("Execution path of file:"+pathOfFile.);

		repository = new ArrayList<T>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathOfFile.toString()))) {
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				T data = typeArgumentClass.newInstance();
				data.Load(attributes);
				repository.add(data);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			System.out.println("Some Exception");
		} catch (Exception e) {
			System.out.println("Some Exception");
		}
		return repository;
	}
}
