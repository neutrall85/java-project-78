### Hexlet tests and linter status:
[![Actions Status](https://github.com/neutrall85/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/neutrall85/java-project-78/actions)

### Sonar Bages:
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=neutrall85_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=neutrall85_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=neutrall85_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=neutrall85_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=neutrall85_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=neutrall85_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=neutrall85_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=neutrall85_java-project-71)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=neutrall85_java-project-71&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=neutrall85_java-project-71)

## Java Validator Library
___

## Описание проекта
Java Validator Library — это мощная библиотека для валидации различных типов данных в Java-приложениях. Проект предоставляет гибкий и расширяемый механизм проверки данных, который можно легко интегрировать в существующие приложения.

Проект выполнен в рамках курса "Java-разработчик" от онлайн-школы Hexlet
## Основные возможности
- Валидация строковых значений
- Проверка числовых данных
- Работа с коллекциями и картами
- Настраиваемые правила валидации
- Простое расширение функционала
## Компоненты системы
### Validator
Основной класс системы, предоставляющий методы для создания схем валидации:
- string() — для строковых значений
- number() — для числовых значений
- map() — для работы с коллекциями
### StringSchema
- required() — установка обязательности поля
- minLength(int length) — минимальная длина строки
- contains(String pattern) — проверка наличия подстроки
### NumberSchema
- required() — обязательность поля
- positive() — проверка на положительное значение
- range(int min, int max) — установка диапазона значений
### MapSchema
- required() — обязательность карты
- sizeof(int size) — проверка размера коллекции
- shape(Map<String, BaseSchema> rules) — настройка правил валидации

## Вклад в проект
*Приветствуется вклад в развитие проекта! Если вы хотите помочь улучшить библиотеку, пожалуйста, создайте issue или pull request.*

