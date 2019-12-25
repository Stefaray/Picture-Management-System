package domain;

import java.util.Arrays;

public class Dir  {
    private String[] dirs;

    public String[] getDirs() {
        return dirs;
    }

    public void setDirs(String[] dirs) {
        this.dirs = dirs;
    }

    @Override
    public String toString() {
        return "Dir{" +
                "dirs=" + Arrays.toString(dirs) +
                '}';
    }

}
