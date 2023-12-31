package me.alexzander700.sfBarrels;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class sfBarrels extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        NamespacedKey categoryId = new NamespacedKey(this, "better_barrels");
        CustomItemStack categoryItem = new CustomItemStack(Material.BARREL, "&3Better Barrels");
        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        SlimefunItemStack itemStack = new SlimefunItemStack("BETTER_BARREL", Material.BARREL, "&6Better Barrel", "", "A barrel that will hold a metric ton of items.");

        ItemStack[] recipe = {new ItemStack(Material.OAK_LOG), new ItemStack(Material.ENDER_EYE), new ItemStack(Material.OAK_LOG), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.BARREL), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.OAK_LOG), SlimefunItems.PLASTIC_SHEET, new ItemStack(Material.OAK_LOG)};

        SlimefunItem sfItem = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        sfItem.register(this);

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
