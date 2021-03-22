package com.example.demo.solution1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceImpl implements com.example.demo.solution1.Service {

    private final Repository repository;


    @Override
    @Transactional
    public void post(final String s) {
        try {
            if (!repository.findById(s).isPresent()) {
                final Entity e = new Entity();
                e.setId(s);
                e.setValue(longestPalindromicSubstringGen(s));
                repository.saveAndFlush(e);
            }
        } catch (final Exception e) {
            log.error("Exception in POST: ", e);
            throw e;
        }
    }

    @Override
    public String get(final String s) {
        try {
            final Optional<Entity> e = repository.findById(s);
            return e.isPresent() ? e.get().getValue() : null;
        } catch (final Exception e) {
            log.error("Exception in GET: ", e);
            throw e;
        }
    }

    private String longestPalindromicSubstringGen(final String s) {
        String value = "";
        for (int i = 0; i < s.length(); i++) {
            final int len1 = expand(s, i, i + 1);
            final int len2 = expand(s, i - 1, i + 1);
            if (len1 > len2 && len1 > value.length())
                value = s.substring(i - len1 / 2 + 1, i + len1 / 2 + 1);
            else if (len1 < len2 && len2 > value.length())
                value = s.substring(i - len2 / 2, i + len2 / 2 + 1);
        }
        return value;
    }

    private int expand(final String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
