using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(practica.Startup))]
namespace practica
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
