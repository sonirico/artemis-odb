package com.artemis.cli;

import java.io.File;

import com.artemis.cli.converter.FileOutputConverter;
import com.artemis.cli.converter.FolderConverter;
import com.artemis.model.ComponentDependencyMatrix;
import com.beust.jcommander.Parameter;

public class MatrixCommand {
	static final String COMMAND = "matrix";
	
	@Parameter(
			names = {"-l", "--label"},
			description = "Project name.",
			required = false)
		String projectName = "Unknown artemis project";
		
		@Parameter(
			names = {"-c", "--class-folder"},
			description = "Root class folder",
			converter = FolderConverter.class,
			required = true)
		File classRoot;
		
		@Parameter(
			names = {"-o", "--output"},
			description = "Save to file",
			converter = FileOutputConverter.class,
			required = false)
		File output = new File("matrix.html");
		
		void execute() {
			ComponentDependencyMatrix cdm = 
				new ComponentDependencyMatrix(projectName, classRoot, output);
			cdm.process();
		}
}