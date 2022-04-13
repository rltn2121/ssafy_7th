use world;

select @@autocommit;
set autocommit=false;

-- 1
select count(*) as 전체, count(indepyear) as '독립 연도 보유'
from country;

-- 2
select sum(LifeExpectancy) as 합계, round(avg(LifeExpectancy),2) as 평균, max(LifeExpectancy) as 최대, min(LifeExpectancy) as 최소
from country;

-- 3
select continent, count(*) as '국가 수', sum(population) as '인구 합'
from country
group by continent
order by count(*) desc;

-- 4
select continent, sum(surfacearea) as '표면적 합'
from country
group by continent
order by sum(surfacearea) desc
limit 3;

-- 5
select continent, sum(gnp) as 'gnp 합'
from country
where population >= 50000000
group by continent
order by sum(gnp);

-- 6
select continent, sum(gnp) as 'gnp 합'
from country
where population >= 50000000
group by continent
having sum(gnp) >= 5000000;

-- 7
select indepyear, count(*) as '독립 국가 수'
from country
where indepyear is not null
group by indepyear
having count(*) >= 10;

-- 8
select continent, name, gnp, (select avg(gnp) from country) as '전세계 평균', avg(gnp) over (partition by continent) as '대륙 평균'
from country
group by name;



-- 1. country에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
-- select count(code) "전체", count(indepyear) "독립 연도 보유" from country;

-- 2. country에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2자리로 반올림한다.
-- select sum(lifeexpectancy) "합계", round(avg(lifeexpectancy), 2) "평균", max(lifeexpectancy) "최대", min(lifeexpectancy) "최소" from country;

-- 3. country에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.
-- select continent, count(code) "국가 수", sum(population) "인구 합"from country group by continent order by 2 desc;

-- 4. country에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3건만 출력한다.
-- select continent, sum(surfacearea) "표면적 합" from country group by continent order by 2 desc limit 3;

-- 5. country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다.
-- select continent, sum(gnp) "gnp 합" from country  where population >=50000000 group by continent;

-- 6. country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 이때 gnp의 합이 5,000,000 이상인 것만 구하시오.
-- select continent, sum(gnp) "gnp 합" from country  where population >=50000000 group by continent having sum(gnp)>=5000000;

-- 7. country에서 연도별로 10개 이상의 나라가 독립한 해는 언제인가?
-- select indepyear, count(indepyear) "독립 국가 수" from country group by indepyear having count(indepyear) >=10 order by 2 desc;

-- 8. country에서 국가별로 gnp와 함께 전세계 평균 gnp, 대륙 평균 gnp를 출력하시오.(239건)
-- select continent, name, gnp, avg(gnp) over() "전세계 평균", avg(gnp) over(partition by continent) "대륙 평균" from country;