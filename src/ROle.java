/**
 * Demo class
 * @author liuchao
 * @date 2022/10/12
 */
import java.util.*;
    public class ROle {
        public static void main(String[] args) {
            class cont{
                Set<String> role=new HashSet<>();
                cont(String rolename){role.add(rolename);}
            }
            Scanner sc = new Scanner(System.in);
            class role {
                String name;
                role(String name){
                    this.name=name;
                }
                public final Set<String> opl = new TreeSet<>();
                public final Set<String> opt = new TreeSet<>();
                public final Set<String> opn = new TreeSet<>();
            }
            Map<String, role> mr = new HashMap<>();
            Map<String, cont> mg = new HashMap<>();
            Map<String,cont> mpu=new HashMap<>();
            int n=sc.nextInt();
            int m=sc.nextInt();
            int q=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                String name=sc.next();
                role c = new role(name);


                int nl=sc.nextInt();
                for(int j=0;j<nl;j++)
                {
                    String op=sc.next();
                    c.opl.add(op);
                }

                int nt=sc.nextInt();
                for(int j=0;j<nt;j++){
                    String op=sc.next();
                    c.opt.add(op);
                }

                int nn=sc.nextInt();
                for(int j=0;j<nn;j++)
                {
                    String op=sc.next();
                    c.opn.add(op);

                }
                mr.put(name,c);
            }
            for(int i=0;i<m;i++)
            {

                String rolename=sc.next();
                int k=sc.nextInt();

                for(int j=0;j<k;j++)
                {
                    String c=sc.next();
                    String name=sc.next();
                    if(c.compareTo("g")==0){
                        if(mg.containsKey(name))
                        {

                            mg.get(name).role.add(rolename);
                        }
                        else {
                            mg.put(name,new cont(rolename) );
                        }
                    }
                    else {
                        if(mpu.containsKey(name)){
                            mpu.get(name).role.add(rolename);
                        }else{
                            mpu.put(name,new cont(rolename));
                        }


                    }
                }
            }
            for(int i=0;i<q;i++)
            {

                String username=sc.next();

                int k=sc.nextInt();
                String[] ss=new String[k];
                for(int j=0;j<k;j++)
                {
                    ss[j]=sc.next();

                }
                String ol=sc.next();
                String ot=sc.next();
                String on=sc.next();
                boolean f=false;
                if(mpu.containsKey(username))
                {
                    for(String rolename:mpu.get(username).role){
                        if(mr.containsKey(rolename)){
                            role r=mr.get(rolename);
                            if(r.opl.contains(ol)||r.opl.contains("*"))
                            {
                                if(r.opt.contains(ot)||r.opt.contains("*"))
                                {
                                    if(r.opn.isEmpty()||r.opn.contains(on)){
                                        f=true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if(f)
                {
                    System.out.println(1);
                    continue;
                }
                for(String s:ss) {
                    boolean ff = false;
                    if (mg.containsKey(s)) {
                        for (String rolename : mg.get(s).role) {
                            if (mr.containsKey(rolename)) {
                                role r = mr.get(rolename);
                                if (r.opl.contains(ol) || r.opl.contains("*")) {
                                    if (r.opt.contains(ot) || r.opt.contains("*")) {
                                        if (r.opn.isEmpty() || r.opn.contains(on)) {
                                            f = true;
                                            ff = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (ff) {
                        break;
                    }
                }
                System.out.println(f?1:0);


            }
        }
    }





