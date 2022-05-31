package group;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class WordContainedInTitleMatcher extends TypeSafeMatcher<String> {
    private final String title;
    public WordContainedInTitleMatcher(String title) {
        this.title = title;
    }

    @Override
    public boolean matchesSafely(String word) {
        return title.toLowerCase().contains(word.toLowerCase());
    }

    @Override
    protected void describeMismatchSafely(String word, Description mismatchDescription) {
        mismatchDescription.appendText("The title is missing the word -").appendValue(word);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("The title contains the word").appendValue(title);
    }

    public static Matcher<String> WordContainedInTitle(String title) {
        return new WordContainedInTitleMatcher(title);
    }
}
