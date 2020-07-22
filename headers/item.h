#pragma once
#include <string>
#include <unordered_map>
#include <vector>
#include <memory>


class Item
{
protected:
	const std::string sName;

	Item(std::string_view name) noexcept;
	Item(const Item& other) noexcept = delete;
	Item(Item&& other) noexcept;

public:
	const std::string& name() const noexcept;
};


/*######################################*/


class Gun : public Item
{
private:
	const double min;
	const double max;
	const char rate;

public:
	Gun(std::string_view name, const double min, const double max, const int rate) noexcept;
	Gun(const Gun& other) noexcept = delete;
	Gun(Gun&& other) noexcept;

	double dmg() const noexcept;
};


/*######################################*/


enum class ItemType { gun };


/*######################################*/


class ItemFactory
{
private:
	static const std::unordered_map<ItemType, std::vector<std::string>> types;
	static const std::unordered_map<ItemType, int> typeLimits;

public:
	static ItemType lookUp(std::string_view name) noexcept;
	static bool isValid(std::string_view name) noexcept;
	static int typeLimit(const ItemType type) noexcept;
	static std::unique_ptr<Item> createItem(std::string_view name) noexcept;
};