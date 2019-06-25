package com.codeclan.example.filesHomework.components;

import com.codeclan.example.filesHomework.details.ExtensionType;
import com.codeclan.example.filesHomework.models.File;
import com.codeclan.example.filesHomework.models.Folder;
import com.codeclan.example.filesHomework.models.User;
import com.codeclan.example.filesHomework.repositories.FileRepository;
import com.codeclan.example.filesHomework.repositories.FolderRepository;
import com.codeclan.example.filesHomework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }


    @Override
    public void run(ApplicationArguments args) {

        User fred = new User("Fred");
        userRepository.save(fred);

        Folder folder1 = new Folder("Intro", fred);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Data", fred);
        folderRepository.save(folder2);

        File file1 = new File("Introduction", ExtensionType.TXT, 10, folder2);
        fileRepository.save(file1);

        File file2 = new File("Details", ExtensionType.JAVA, 15, folder2);
        fileRepository.save(file2);

    }
}
