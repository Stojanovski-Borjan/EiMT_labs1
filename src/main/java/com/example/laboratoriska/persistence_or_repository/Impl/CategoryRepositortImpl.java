package com.example.laboratoriska.persistence_or_repository.Impl;

import com.example.laboratoriska.Model.Category;
import com.example.laboratoriska.persistence_or_repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositortImpl implements CategoryRepository {

    private HashMap<Long, Category> categories;
    private AtomicLong counter;

    @PostConstruct
    public void init(){
        this.categories = new HashMap<>();
        counter = new AtomicLong(0);
        Long id = counter.getAndIncrement();

        this.categories.put(id, new Category(id, "Роман", " Роман е долго раскажувачко литературно дело засновано на замислена приказна, односно кое не се потпира целосно на факти. За првпат романот како литературна форма се појавил во 11. век, но поради широките можности останал во употреба и во современата литература."));
        id = counter.getAndIncrement();
        this.categories.put(id, new Category(id, "Трилер", "Трилерот е простран жанр кој ги опфаќа литературата, филмот и телевизијата, каде што главни елементи се исчекување, тензија и возбуда. Трилерите многу го стимулираат расположението на гледачите, со тоа што им предизвикуваат висoкото ниво на предвидување на нештата, премногу зголемено исчекување, несигурност, изненадување, вознемиреност и страв."));
        id = counter.getAndIncrement();
        this.categories.put(id, new Category(id, "Поезија", "Поезија или лирика е уметничка форма во која човечкиот јазик се користи за неговите естетски квалитети во додаток на, или место за, неговата семантичка содржина. Поезијата се состои претежно од усни или литературни дела во кои јазикот се користи на начин што јасно се разликува од тој на обичната проза. Основната одлика на јазикот на поезијата е во она што го нарекуваме ритмичност."));

    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(this.categories.values());
    }

    @Override
    public List<Category> findAllByName(String categoryName) {
        return this.categories.values()
                .stream()
                .filter(item -> item.getCategoryName().contains(categoryName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categories.get(id));
    }

    @Override
    public Category saveCategory(Category category) {
        if(category.getId() == null){
            category.setId(this.counter.getAndIncrement());
        }
        this.categories.put(category.getId(), category);
        return category;
    }

    @Override
    public void deleteById(Long id) {
        this.categories.remove(id);
    }
}
