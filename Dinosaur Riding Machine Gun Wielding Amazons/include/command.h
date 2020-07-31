#ifndef COMMAND_H
#define COMMAND_H

#include <string>
#include <unordered_map>

#include "map.h"
#include "player.h"


class CommandHandler
{
private:
    std::unordered_map<std::string, std::string(CommandHandler::*)(const std::vector<std::string>&, Map&, GameData&) const noexcept> commands;
	CommandHandler() noexcept;
    std::string New(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Select(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Move(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Help(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Lookaround(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Attack(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Pickup(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Drop(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Equip(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string End(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Tame(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Geton(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Getoff(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string List(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Status(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
	std::string Steps(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;

public:
	CommandHandler(CommandHandler&& other) noexcept = delete;
	static CommandHandler& instance() noexcept;
    std::string handleCommand(const std::vector<std::string>& v, Map& map, GameData& data) const noexcept;
};

#endif