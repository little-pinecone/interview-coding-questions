package in.keepgrowing.interviewcodingquestions.datastructures.set.powerset;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;

public class PowerSetGenerator {

    public Set<Set<Integer>> generateRecursively(Set<Integer> numbers) {
        if (null == numbers || numbers.isEmpty()) {
            return Set.of(emptySet());
        }

        Integer number = numbers.iterator().next();

        Set<Integer> withoutNumber = getSubSetWithoutNumber(numbers, number);
        Set<Set<Integer>> allWithoutNumber = generateRecursively(withoutNumber);
        Set<Set<Integer>> allWithNumber = addNumber(allWithoutNumber, number);

        Set<Set<Integer>> powerSet = new HashSet<>();
        Stream.of(allWithoutNumber, allWithNumber).forEach(powerSet::addAll);

        return powerSet;
    }

    private Set<Integer> getSubSetWithoutNumber(Set<Integer> numbers, Integer number) {
        return numbers.stream()
                .filter(e -> !Objects.equals(e, number))
                .collect(Collectors.toSet());
    }

    private Set<Set<Integer>> addNumber(Set<Set<Integer>> powerSetSubSetWithoutElement, Integer element) {
        return powerSetSubSetWithoutElement.stream()
                .map(subsetWithoutElement -> {
                    Set<Integer> subsetWithElement = new HashSet<>(subsetWithoutElement);
                    subsetWithElement.add(element);
                    return subsetWithElement;
                })
                .collect(Collectors.toSet());
    }

    public Set<Set<Integer>> withBitwiseApproach(List<Integer> numbers) {
        long subsetAmount = (long) Math.pow(2, numbers.size());

        return generateSubSets(numbers, subsetAmount);
    }

    private Set<Set<Integer>> generateSubSets(List<Integer> numbers, long subsetAmount) {
        Set<Set<Integer>> subsets = new HashSet<>();
        for (int i = 0; i < subsetAmount; i++) {
            Set<Integer> set = generateSubSet(numbers, i);
            subsets.add(set);
        }

        return subsets;
    }

    private Set<Integer> generateSubSet(List<Integer> numbers, int subSetIndex) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            if ((subSetIndex & getSquared(i)) != 0) {
                set.add(numbers.get(i));
            }
        }

        return set;
    }

    private int getSquared(int i) {
        return 1 << i;
    }
}
