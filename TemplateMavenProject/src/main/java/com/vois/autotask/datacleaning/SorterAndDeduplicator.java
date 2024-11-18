package com.vois.autotask.datacleaning;

import lombok.NoArgsConstructor;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

@NoArgsConstructor
public class SorterAndDeduplicator {
    private final Screen screen = new Screen();
    private final String projectPath = System.getProperty("user.dir") + "\\img\\";

    // Paths for open excel file
    private final Pattern excelIcon = new Pattern(projectPath + "excel-icon.png");
    private final Pattern open = new Pattern(projectPath + "open.png");
    private final Pattern browse = new Pattern(projectPath + "browse.png");
    private final Pattern inputFilePath = new Pattern(projectPath + "file-path.png");
    private final Pattern openFile = new Pattern(projectPath + "open-file.png");

    // Paths for sort column
    private final Pattern dataTab = new Pattern(projectPath + "data.png");
    private final Pattern sort = new Pattern(projectPath + "sort.png");
    private final Pattern columnToSortBy = new Pattern(projectPath + "sort-by.png");
    private final Pattern joinDate = new Pattern(projectPath + "join-date.png");
    private final Pattern okSortBtn = new Pattern(projectPath + "ok-sort.png");
    private final Pattern homeTab = new Pattern(projectPath + "home.png");

    // paths for removing duplicates
    private final Pattern columnB = new Pattern(projectPath + "B.png");
    private final Pattern advancedButton = new Pattern(projectPath + "advanced.png");
    private final Pattern uniqueOnlyChkBox = new Pattern(projectPath + "check-box.png");
    private final Pattern okUniqueBtn = new Pattern(projectPath + "ok-unique.png");


    public void openExcelFile(String filePath) {
        try {
            screen.doubleClick(excelIcon);
            screen.wait(open, 30);
            screen.doubleClick(open);
            screen.doubleClick(browse);
            screen.type(inputFilePath, filePath);
            screen.click(openFile);
        } catch (FindFailed e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void sortByDate() {
        try {
            // press CTRL + A >> Select all
            screen.keyDown(Key.CTRL);
            screen.type("a");
            screen.keyUp(Key.CTRL);

            screen.wait(dataTab,60);
            screen.click(dataTab);
            screen.click(sort);
            screen.click(columnToSortBy);
            screen.click(joinDate);
            screen.click(okSortBtn);
            screen.click(homeTab);

        } catch (FindFailed e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void removeDuplicatesByName() {
        try {
            screen.click(columnB);
            screen.click(dataTab);
            screen.click(advancedButton);
            screen.click(uniqueOnlyChkBox);
            screen.click(okUniqueBtn);
        } catch (FindFailed e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void saveExcelFile() {
        // Save file
        screen.keyDown(Key.CTRL);
        screen.type("s");
        screen.keyUp(Key.CTRL);
        System.out.println("Done saving excel file");
    }
}
