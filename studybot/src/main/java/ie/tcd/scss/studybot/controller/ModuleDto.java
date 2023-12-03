package ie.tcd.scss.studybot.controller;

import ie.tcd.scss.studybot.domain.Module;

public class ModuleDto {

    private Module module;

    public ModuleDto(Module module) {
        this.module = module;
    }

    public ModuleDto() {

    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getName() {
        return module.getName();
    }

    public void setName(String name) {
        this.module.setName(name);
    }

    public String getDescription() {
        return module.getDescription();
    }

    public void setDescription(String description) {
        this.module.setDescription(description);
    }

    public double getHighestScore() {
        return module.getHighestScore();
    }

    public void setHighestScore(double highestScore) {
        this.module.setHighestScore(highestScore);
    }
}
