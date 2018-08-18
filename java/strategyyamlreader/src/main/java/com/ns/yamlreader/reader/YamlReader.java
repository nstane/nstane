package com.ns.yamlreader.reader;

import com.ns.yamlreader.YamlObject;

public interface YamlReader {
	YamlObject readYaml(String fileName);
}
