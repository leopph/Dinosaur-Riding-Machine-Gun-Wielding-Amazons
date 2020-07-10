#pragma once

#include "dino.h"
#include "item.h"

class Amazon
{
private:
	const std::string name;
	double hp;
	std::unordered_map<ItemType, std::vector<std::unique_ptr<Item>>> inventory;
	Gun* held;
	std::unique_ptr<Dino> dino;

public:
	Amazon(std::string_view name);
	bool hasFreeSlot(ItemType type);
	bool hasItem(std::string_view name);
	void take(std::unique_ptr<Item>&& item);
	std::unique_ptr<Item> remove(std::string_view name);
	Item* item(std::string_view name);
	const std::string& get_name();
	double& get_hp();
	Gun*& hand();
	Dino* get_dino();
	void setDino(std::unique_ptr<Dino>&& dino);
};