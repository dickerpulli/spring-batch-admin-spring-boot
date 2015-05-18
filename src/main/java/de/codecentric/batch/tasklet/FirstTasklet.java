package de.codecentric.batch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FirstTasklet implements Tasklet {

    private String property; 
    
    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        
        // print in the console just to prove it's using our property
        System.out.println(property);
        
        return RepeatStatus.FINISHED;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
