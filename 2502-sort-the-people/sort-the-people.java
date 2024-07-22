class Solution {
    static class Person{
        String name;
        int height;

        Person(String name, int height){
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n= names.length;
        List<Person> people = new ArrayList<>();

        for(int i=0; i< n; i++){
            people.add(new Person(names[i], heights[i]));
        }

        //sort people in desc order of heights
        Collections.sort(people, (a,b)-> b.height - a.height);

        int i=0;
        for(Person person: people){
            names[i++] = person.name;
        }

        return names;
    }
}